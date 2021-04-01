package net.rkoubou.dddcommons;

import java.util.Objects;

public class StringValue implements ValueObject<String>, Comparable<StringValue>
{
    protected final String value;

    public StringValue( String value )
    {
        this( value, false );
    }

    protected StringValue( String value, boolean checkEmpty )
    {
        if( checkEmpty && value.trim().equals( "" ))
        {
            throw new IllegalArgumentException();
        }

        this.value = value;
    }

    @Override
    public String get()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return value;
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
        StringValue that = (StringValue)other;
        return Objects.equals( value, that.value );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( value );
    }

    @Override
    public int compareTo( StringValue other )
    {
        return value.compareTo( other.value );
    }
}
