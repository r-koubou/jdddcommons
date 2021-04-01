package net.rkoubou.dddcommons;

import java.util.Objects;

abstract public class LongValue implements ValueObject<Long>, Comparable<LongValue>
{
    protected final Long value;

    public LongValue( Long value )
    {
        this( value, false );
    }

    protected LongValue( Long value, boolean checkMinMax )
    {
        if( checkMinMax && value < min() || value > max() )
        {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    @Override
    public Long get()
    {
        return value;
    }

    public Long min()
    {
        return Long.MIN_VALUE;
    }

    public Long max()
    {
        return Long.MAX_VALUE;
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
        LongValue byteValue = (LongValue)other;
        return Objects.equals( value, byteValue.value );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( value );
    }

    @Override
    public int compareTo( LongValue other )
    {
        return value.compareTo( other.value );
    }
}
