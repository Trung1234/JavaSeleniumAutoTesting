package interfaces;

public interface LoginPage {
	void enterUsername(String username);

	void enterPassword(String password);

	void clickLogin();

	boolean isLoginSuccessful();
}
