package net.rkoubou.dddcommons;

import java.util.Objects;

abstract public class FloatValue implements ValueObject<Float>, Comparable<FloatValue>
{
    protected final Float value;

    public FloatValue( Float value )
    {
        this( value, false );
    }

    protected FloatValue( Float value, boolean checkMinMax )
    {
        if( checkMinMax && value < min() || value > max() )
        {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    @Override
    public Float get()
    {
        return value;
    }

    public Float min()
    {
        return Float.MIN_VALUE;
    }

    public Float max()
    {
        return Float.MAX_VALUE;
    }

    @Override
    public String toString()
    {
        return value.toString();
    }

    @Override
    public boolean equals( Object other )
    {
        if( this == other )
        {
            return true;
        }
        if( other == null || getClass() != other.getClass() )
        {
            return false;
        }
        FloatValue byteValue = (FloatValue)other;
        return Objects.equals( value, byteValue.value );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( value );
    }

    @Override
    public int compareTo( FloatValue other )
    {
        return value.compareTo( other.value );
    }
}
