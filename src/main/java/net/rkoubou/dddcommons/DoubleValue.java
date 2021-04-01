package net.rkoubou.dddcommons;

import java.util.Objects;

abstract public class DoubleValue implements ValueObject<Double>, Comparable<DoubleValue>
{
    protected final Double value;

    public DoubleValue( Double value )
    {
        this( value, false );
    }

    protected DoubleValue( Double value, boolean checkMinMax )
    {
        if( checkMinMax && value < min() || value > max() )
        {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    @Override
    public Double get()
    {
        return value;
    }

    public Double min()
    {
        return Double.MIN_VALUE;
    }

    public Double max()
    {
        return Double.MAX_VALUE;
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
        DoubleValue byteValue = (DoubleValue)other;
        return Objects.equals( value, byteValue.value );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( value );
    }

    @Override
    public int compareTo( DoubleValue other )
    {
        return value.compareTo( other.value );
    }
}
