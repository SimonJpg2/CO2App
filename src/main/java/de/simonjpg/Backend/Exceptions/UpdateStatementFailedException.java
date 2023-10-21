package de.simonjpg.Backend.Exceptions;

import java.sql.SQLException;

public class UpdateStatementFailedException extends SQLException {
    public UpdateStatementFailedException(String reason) {
        super(reason);
    }

    public UpdateStatementFailedException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
