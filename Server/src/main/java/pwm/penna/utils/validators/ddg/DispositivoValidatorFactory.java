package pwm.penna.utils.validators.ddg;

public class DispositivoValidatorFactory { //teoricamente è anche un singleton
	private static final DispositivoDiGiocoValidator ddgValidator = new DispositivoDiGiocoValidator();
	private static final PlayStationValidator playValidator = new PlayStationValidator();
	private static final WindowsValidator winValidator = new WindowsValidator();
	private static final XboxValidator xboxValidator = new XboxValidator();

	public static DispositivoDiGiocoValidator getDispositivoDiGiocoValidator() {
		return ddgValidator;
	}

	public static PlayStationValidator getPlayStationValidator() {
		return playValidator;
	}

	public static WindowsValidator getWindowsValidator() {
		return winValidator;
	}

	public static XboxValidator getXboxValidator() {
		return xboxValidator;
	}
}
