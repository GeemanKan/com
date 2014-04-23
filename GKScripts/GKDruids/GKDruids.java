package GKScripts.GKDruids;

import java.util.*;

import org.powerbot.script.Script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt6.ClientContext;

import GKScripts.GKDruids.framework.*;
import GKScripts.GKDruids.tasks.fighting.Abilities;
import GKScripts.GKDruids.tasks.fighting.Antiban;
import GKScripts.GKDruids.tasks.fighting.Fight;
import GKScripts.GKDruids.tasks.fighting.Loot;
import GKScripts.GKDruids.tasks.walking.*;

@Manifest(description = "Kills chaos druids in the Edgeville Dungeon", name = "GKDruids")

public class GKDruids extends PollingScript<ClientContext> {

	List<Task> tasks = new ArrayList<Task>();
	
	public void start(){
		
		new Methods(ctx);
		
		tasks.add(new BankToLadder(ctx));
		tasks.add(new Fight(ctx));
		tasks.add(new LadderToDoor(ctx));
		tasks.add(new DoorToDoor(ctx));
		tasks.add(new Abilities(ctx));
		tasks.add(new Loot(ctx));
		tasks.add(new Antiban(ctx));
	
	}
	
	public void poll() {
		for(Task t : tasks){
			if(t.ready()){
				t.run();
			}
		}
	}

}
