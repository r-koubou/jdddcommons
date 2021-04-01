package net.rkoubou.dddcommons;

import java.util.Objects;

abstract public class IntValue implements ValueObject<Integer>, Comparable<IntValue>
{
    protected final Integer value;

    public IntValue( Integer value )
    {
        this( value, false );
    }

    protected IntValue( Integer value, boolean checkMinMax )
    {
        if( checkMinMax && value < min() || value > max() )
        {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    @Override
    public Integer get()
    {
        return value;
    }

    public Integer min()
    {
        return Integer.MIN_VALUE;
    }

    public Integer max()
    {
        return Integer.MAX_VALUE;
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
        IntValue byteValue = (IntValue)other;
        return Objects.equals( value, byteValue.value );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( value );
    }

    @Override
    public int compareTo( IntValue other )
    {
        return value.compareTo( other.value );
    }
}
