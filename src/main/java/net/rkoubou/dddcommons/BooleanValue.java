package net.rkoubou.dddcommons;

import java.util.Objects;

abstract public class BooleanValue implements ValueObject<Boolean>
{
    protected final Boolean value;

    public BooleanValue( Boolean value )
    {
        this.value = value;
    }

    @Override
    public Boolean get()
    {
        return value;
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
        BooleanValue that = (BooleanValue)other;
        return Objects.equals( value, that.value );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( value );
    }
}
