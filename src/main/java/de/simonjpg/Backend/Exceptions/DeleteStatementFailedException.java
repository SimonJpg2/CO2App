package de.simonjpg.Backend.Exceptions;

import java.sql.SQLException;

public class DeleteStatementFailedException extends SQLException {
    public DeleteStatementFailedException(String reason) {
        super(reason);
    }

    public DeleteStatementFailedException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
