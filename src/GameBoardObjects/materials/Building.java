package GameBoardObjects.materials;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import GameBoardObjects.parrents.Material;
import interfaces.GameConfig;

public class Building extends Material{
	private Color color;
	private boolean isPassable 	= true;
	public boolean isColumn 	= false;
	private String infoString = "";
	public Building(int row, int col, Color color) {
		super(row, col, color);
		this.color = color;
	}

	public Building(int row, int col, boolean isColumn, Color color) {
		super(row, col, color);
		this.color = color;
		this.isColumn = isColumn;
	}

	public Building(int row, int col, Color color, boolean isPassable) {
		super(row, col, color);
		this.color = color;
		this.isPassable = isPassable;
	}

	public void setInfoString(String infoString){
		this.infoString = infoString;
	}

	@Override
	public void render(Graphics g) {
		int tileX = this.col * GameConfig.TILESIZE; 
		int tileY = this.row * GameConfig.TILESIZE;

		int placementCoefficientX = (GameConfig.TILESIZE / 2) - 10;
		int placementCoefficientY = (GameConfig.TILESIZE / 2) + 7;
		
		g.setColor(this.color);
		g.fillRect(tileX, tileY, GameConfig.TILESIZE, GameConfig.TILESIZE);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(tileX, tileY, GameConfig.TILESIZE, GameConfig.TILESIZE);

		if(this.isColumn == true && this.infoString.isEmpty()){
			g.setColor(Color.BLACK);
			g.setFont(new Font("", Font.ITALIC, 20));
			g.drawString("X", tileX + placementCoefficientX, tileY  + placementCoefficientY);
		}else{
			g.setColor(Color.BLACK);
			g.setFont(new Font("", Font.ITALIC, 20));
			g.drawString(this.infoString, tileX + placementCoefficientX, tileY  + placementCoefficientY);
		}
		
	}

	public String colorToString(){
		return getColor().toString();
	}

	public Color getColor(){
		return this.color;
	}

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getPassability() {
		return this.isPassable;
	}
}
