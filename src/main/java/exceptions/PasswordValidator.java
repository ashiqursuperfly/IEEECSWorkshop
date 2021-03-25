package exceptions;

class InvalidPasswordLengthException extends Exception {

    private static final int MIN_ALLOWED_LENGTH = 6;

    public static boolean validate(String password) {
        return password.length() >= MIN_ALLOWED_LENGTH;
    }

    public InvalidPasswordLengthException(String password) {
        super("Invalid Password Length. Expected: "+ MIN_ALLOWED_LENGTH + " Found: "+ password.length());
    }

}

class InvalidPasswordCharsException extends Exception {

    public static boolean validate(String password) {
        if (password.contains("@") || password.contains("$")) return false;
        return true;
    }

    public InvalidPasswordCharsException(String password) {
        super("Password cannot contain @, $ symbols");
    }

}

class PasswordValidator {

    private static void validatePasswordChars(String password) throws InvalidPasswordCharsException {
        if (!InvalidPasswordCharsException.validate(password)) throw new InvalidPasswordCharsException(password);
    }

    private static void validatePasswordLength(String password) throws InvalidPasswordLengthException {
        if (!InvalidPasswordLengthException.validate(password)) throw new InvalidPasswordLengthException(password);
    }

    static void validatePassword(String password) throws InvalidPasswordCharsException, InvalidPasswordLengthException{
        validatePasswordChars(password);
        validatePasswordLength(password);
    }

    public static void main(String[] args) throws InvalidPasswordLengthException, InvalidPasswordCharsException {
        validatePassword("2311@");
    }
}

