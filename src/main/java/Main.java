import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import configuration.ControllerModule;
import configuration.DiscordListener;
import configuration.RestModule;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main extends AbstractModule {

	private Injector injector;

	public static void main(String[] args) throws LoginException {
		new Main().init();
	}

	public void init() throws LoginException {
		this.injector = Guice.createInjector(new ControllerModule(),
				new RestModule());
		this.configListener();
		System.out.println("funca");
	}

	public void configListener() throws LoginException {
		JDABuilder builder = new JDABuilder(AccountType.BOT);
		//todo: poner token de discord
		String token = "";
		builder.setToken(token);
		builder.addEventListener(injector.getInstance(DiscordListener.class));
		builder.buildAsync();
	}
}