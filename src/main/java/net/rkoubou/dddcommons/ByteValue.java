package net.rkoubou.dddcommons;

import java.util.Objects;

abstract public class ByteValue
        implements ValueObject<Byte>, Comparable<ByteValue>
{
    protected final Byte value;

    public ByteValue( Byte value )
    {
        this( value, false );
    }

    protected ByteValue( Byte value, boolean checkMinMax )
    {
        if( checkMinMax && value < min() || value > max() )
        {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    @Override
    public Byte get()
    {
        return value;
    }

    public Byte min()
    {
        return Byte.MIN_VALUE;
    }

    public Byte max()
    {
        return Byte.MAX_VALUE;
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
        ByteValue byteValue = (ByteValue)other;
        return Objects.equals( value, byteValue.value );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( value );
    }

    @Override
    public int compareTo( ByteValue other )
    {
        return value.compareTo( other.value );
    }
}
