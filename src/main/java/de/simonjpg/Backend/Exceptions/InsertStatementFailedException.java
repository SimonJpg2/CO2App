package de.simonjpg.Backend.Exceptions;

import java.sql.SQLException;

public class InsertStatementFailedException extends SQLException {
    public InsertStatementFailedException(String reason) {
        super(reason);
    }

    public InsertStatementFailedException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
