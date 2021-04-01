package net.rkoubou.dddcommons;

import java.util.Objects;
import java.util.UUID;

abstract public class UuidValue implements ValueObject<UUID>
{
    protected final UUID value;

    public UuidValue()
    {
        this.value = UUID.randomUUID();
    }

    public UuidValue( UUID value )
    {
        this.value = value;
    }

    @Override
    public UUID get()
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
        UuidValue that = (UuidValue)other;
        return Objects.equals( value, that.value );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( value );
    }
}
