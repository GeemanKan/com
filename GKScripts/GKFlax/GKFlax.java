package GKScripts.GKFlax; 

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.*;

import org.powerbot.script.PaintListener;
import org.powerbot.script.Script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.Skills;
import org.powerbot.script.rt6.ClientContext;

import GKScripts.GKFlax.data.Methods;
import GKScripts.GKFlax.data.Methods.Paint;
import GKScripts.GKFlax.framework.Task;
import GKScripts.GKFlax.tasks.*;
import GKScripts.GKFlax.tasks.spin.*;
import GKScripts.GKFlax.tasks.stairs.*;

@Manifest(name = "GKScripts.GKFlax", description = "Spins flax at lumbridge for huge profit")
public class GKFlax extends PollingScript<ClientContext> implements PaintListener {

	private List<Task> tasks = new ArrayList<Task>();
	
	private BufferedImage paintImage = null;
	
	public final int START_XP = ctx.skills.experience(Skills.CRAFTING);;
	public final int START_LVL = ctx.skills.level(Skills.CRAFTING);
	
	public void start(){
		
		new Methods(ctx);
		
		tasks.add(new Bank(ctx));
		tasks.add(new Up(ctx));
		tasks.add(new Interact(ctx));
		tasks.add(new Widget(ctx));
		tasks.add(new Down(ctx));
		tasks.add(new AntiBan(ctx));

		paintImage = downloadImage("http://i.imgur.com/t2OwMl2.png");
		
	}
	
	public void poll() {
		
		for(Task t : tasks){
			if(t.ready()){
				t.run();
			}
		}
		
		try {
			Thread.sleep(Random.nextInt(100, 700));
		} catch (InterruptedException e) {e.printStackTrace();}
		
	}

	public void repaint(Graphics g) {
		
		int xp = ctx.skills.experience(Skills.CRAFTING) - START_XP;
		int lvl = ctx.skills.level(Skills.CRAFTING) - START_LVL;
		
		String lvlText = "";
		
		if(lvl > 0){
			lvlText = lvlText + "( +" + lvl + " )";
		}
		
		g.drawImage(paintImage, 0, 150, null);

		g.setColor(Color.BLACK);
		g.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		g.drawImage(paintImage, 0, 150, null);

		g.drawString("Time Running: " + Paint.time(getRuntime()),
				12, 218);
		g.drawString("Flax Spun: " +  (xp/15), 12, 233);
		g.drawString("Flux/Hour: " + Paint.perHour(xp/15, getRuntime()), 12, 248);
		g.drawString("Exp Gained: " + xp, 12, 263);
		g.drawString("Exp/Hour: "
						+ Paint.perHour(xp,
								getRuntime()), 12, 278);
		g.drawString("Current Level: " + ctx.skills.level(Skills.CRAFTING) + lvlText , 12, 293);
		
	}

}