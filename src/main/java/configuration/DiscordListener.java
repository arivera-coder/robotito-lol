package configuration;

import controller.SummonerController;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DiscordListener extends ListenerAdapter {
	private SummonerController summonerController;
	@Inject
	public DiscordListener(SummonerController summonerController) {
		this.summonerController = summonerController;
	}
	public DiscordListener() {
	}

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {

		System.out.println("We received a message from " +
				event.getAuthor().getName() + ": " +
				event.getMessage().getContentDisplay()
		);

		if (event.getMessage().getContentRaw().equals("!ping")) {
			event.getChannel().sendMessage("Pong!").queue();
		} if(event.getMessage().getContentRaw().startsWith("--robotito ")){
			String name =event.getMessage().getContentRaw();
			name = StringUtils.remove(name,"--robotito ");
			summonerController.getInfo(name);
		}

	}
}
