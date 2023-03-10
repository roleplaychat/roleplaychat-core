package net.xunto.roleplaychat;

import net.xunto.roleplaychat.api.IServer;
import net.xunto.roleplaychat.api.ISpeaker;
import net.xunto.roleplaychat.api.IWorld;
import net.xunto.roleplaychat.api.Position;
import net.xunto.roleplaychat.framework.api.Environment;
import net.xunto.roleplaychat.framework.api.Request;
import org.junit.Before;
import org.mockito.Mockito;

public class ChatTest {
    protected IServer server;
    protected IWorld world;
    protected ISpeaker player;

    @Before
    public void beforeEveryTest() {
        server = Mockito.mock(IServer.class);
        world = Mockito.mock(IWorld.class);

        player = setUpPlayer(new Position(0, 0, 0));

        Mockito.doReturn(new ISpeaker[]{player}).when(world).getPlayers();
        Mockito.doReturn(server).when(world).getServer();

        Mockito.doReturn(new IWorld[]{world}).when(server).getWorlds();
    }

    protected ISpeaker setUpPlayer(Position position) {
        return setUpPlayer("username", position);
    }

    protected ISpeaker setUpPlayer(String username, Position position) {
        ISpeaker player = Mockito.mock(ISpeaker.class);

        Mockito.doReturn(position).when(player).getPosition();
        Mockito.doReturn(username).when(player).getName();
        Mockito.doReturn(world).when(player).getWorld();

        return player;
    }

    protected Request setUpRequest(String text) {
        return new Request(text, player);
    }

    protected Environment setUpEnvironment(String text) {
        return new Environment(player.getName(), text);
    }
}
