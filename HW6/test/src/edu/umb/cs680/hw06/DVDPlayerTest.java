package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DVDPlayerTest {

	@Test
	public void DVDPlaying_ClosedButtonPushed_DrawerClosed() {
		DVDPlayer p = DVDPlayer.getInstance();
		p.playButtonPushed();
		assertEquals(DrawerClosedPlaying.getInstance(), p.getCurrentState());
	}

	@Test
	public void OpenCloseButtonPushed_DVDPlaying_DrawerOpen() {
		DVDPlayer p = DVDPlayer.getInstance();
		p.playButtonPushed();
		p.openCloseButtonPushed();
		assertEquals(DrawerOpen.getInstance(), p.getCurrentState());
	}

	@Test
	public void Stop_StopButtonPushed_DVDPlaying_DrawerClosed() {
		DVDPlayer p = DVDPlayer.getInstance();
		p.playButtonPushed();
		p.stopButtonPushed();
		assertEquals(DrawerClosedNotPlaying.getInstance(), p.getCurrentState());
	}

}
