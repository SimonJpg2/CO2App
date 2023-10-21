package de.simonjpg.Backend.Exceptions;

import java.sql.SQLException;

public class SelectStatementFailedException extends SQLException {
    public SelectStatementFailedException(String reason) {
        super(reason);
    }

    public SelectStatementFailedException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
