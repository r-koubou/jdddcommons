package net.rkoubou.dddcommons;

import java.util.Objects;

abstract public class ShortValue implements ValueObject<Short>, Comparable<ShortValue>
{
    protected final Short value;

    public ShortValue( Short value )
    {
        this( value, false );
    }

    protected ShortValue( Short value, boolean checkMinMax )
    {
        if( checkMinMax && value < min() || value > max() )
        {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    @Override
    public Short get()
    {
        return value;
    }

    public Short min()
    {
        return Short.MIN_VALUE;
    }

    public Short max()
    {
        return Short.MAX_VALUE;
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
        ShortValue byteValue = (ShortValue)other;
        return Objects.equals( value, byteValue.value );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( value );
    }

    @Override
    public int compareTo( ShortValue other )
    {
        return value.compareTo( other.value );
    }
}
