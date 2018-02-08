package pacemaker.conferences.domain.conferences;

import java.util.Objects;
import java.util.UUID;

public final class ConferenceId {
    private final UUID id;

    private ConferenceId(UUID id) {
        this.id = id;
    }

    public static ConferenceId allocate() {
        return new ConferenceId(UUID.randomUUID());
    }

    public static ConferenceId from(String id) {
        return new ConferenceId(UUID.fromString(id));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ConferenceId that = (ConferenceId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return this.id.toString();
    }
}
