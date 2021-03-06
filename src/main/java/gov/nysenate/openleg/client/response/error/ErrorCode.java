package gov.nysenate.openleg.client.response.error;


import java.util.HashMap;
import java.util.Map;

/**
 * Represents the error codes returned by the OpenLeg 3.0 API.
 */
public enum ErrorCode
{
    /** --- Base --- */

    UNKNOWN_ERROR(-1, "There was an unexpected error while handling your request."),

    INVALID_ARGUMENTS(1, "One or more of the provided request parameters was not valid"),
    MISSING_PARAMETERS(2, "A required parameter was missing from the request"),

    /** --- Bill --- */

    BILL_NOT_FOUND(11, "The requested bill was not found"),
    BILL_AMENDMENT_NOT_FOUND(12, "The requested bill amendment was not found"),

    /** --- Law --- */

    LAW_DOC_NOT_FOUND(21, "The requested law document was not found"),
    LAW_TREE_NOT_FOUND(22, "The requested law tree was not found"),

    /** --- Spotcheck --- */

    SPOTCHECK_REPORT_NOT_FOUND(31, "The requested spotcheck report was not found"),

    /** --- Committee --- */

    COMMITTEE_NOT_FOUND(41, "The requested committee was not found"),
    COMMITTEE_VERSION_NOT_FOUND(42, "The requested committee version was not found"),

    /** --- Calendar --- */

    CALENDAR_NOT_FOUND(51, "The requested calendar was not found"),

    /** --- Agenda --- */

    AGENDA_NOT_FOUND(61, "The requested agenda was not found"),

    /** --- General Search --- */

    SEARCH_ERROR(100, "There was error retrieving your search results. Make sure that the query is valid."),

    /** -- Data Process -- */

    PROCESS_RUN_NOT_FOUND(121, "The given data process run was not found"),

    /** --- Source File --- */

    SOURCE_FILE_NOT_FOUND(131, "The source file was not found"),

    /** --- Transcript --- */

    TRANSCRIPT_NOT_FOUND(141, "The transcript was not found"),

    /** --- Member --- */

    MEMBER_NOT_FOUND(151, "The member was not found"),

    /** --- Admin --- */

    USER_ALREADY_EXISTS(191, "The entered username already exists"),
    USER_DOES_NOT_EXIST(192, "The entered username is not currently registered as a user"),
    SAME_PASSWORD(193, "The new password cannot match the existing password"),

    NOTIFICATION_NOT_FOUND(194, "The requested notification was not found"),

    DATA_PROCESS_RUN_FAILED(195, "The data process did not run, due to processing being disabled or an error"),

    /** --- General --- */

    UNAUTHORIZED(401, "Not authorized to perform this request."),
    INVALID_DATE_RANGE(601, "The supplied date range is not valid."),
    API_KEY_REQUIRED(701, "A valid API key is needed to fulfill this request.")
    ;


    /** Used for lookups by code. */

    private static final Map<Integer, String> codeMap = new HashMap<>();
    static {
        for (ErrorCode rc : ErrorCode.values()) {
            codeMap.put(rc.code, rc.name());
        }
    }

    /** Numerical return code. */
    private int code = 0;

    /** Description of return code and possible corrective actions. */
    private String message = "";

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Returns the ErrorCode using the numerical code.
     * @param code int
     * @return ErrorCode if code matches, null otherwise.
     */
    public static ErrorCode getByCode(int code) {
        if (codeMap.containsKey(code)) {
            return ErrorCode.valueOf(codeMap.get(code));
        }
        return null;
    }
}
