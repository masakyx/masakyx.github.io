import  java.awt.*;
import  java.awt.geom.*;

public abstract class DrawObject {
	
	Point2D median; //重心点の位置
	double angle; //回転角度（ラジアン角度）
	double scalex, scaley; //拡大縮小率（マイナスだと鏡像）
	AffineTransform at; //アフィン変換のための変数
	Color framecolor; //枠線のカラー
	Color fillcolor; //塗りつぶしのカラー
	double linewidth; //枠線の幅
	
	//コンストラクタ
	public DrawObject(){
		median = new Point2D.Double(0, 0);
		angle = 0.0;
		scalex = scaley = 1.0;
		at = new AffineTransform();
		framecolor = Color.black;
		linewidth = 1.0;
	}
	
	//Paintメソッドは必要
	public abstract void paint( Graphics g);
	//containsメソッドは必要
	public abstract boolean contains(int x, int y);
	// paintBounds（境界領域を表示する）メソッドは必要
	public abstract void paintBounds( Graphics g );
	
	// paintMedian（重心点を表示する）メソッド、緑で小さな○を重心点に表示する
	public void paintMedian( Graphics g ) {
		g.setColor( Color.green );
		g.drawOval( (int)(median.getX())-3, (int)(median.getY())-3 , 6, 6 );
	}
	//重心点を設定する
	public void setMedian(double x, double y){
		median = new Point2D.Double(x, y);
	}
	
	//重心点をdx,dyだけ移動させる
	public void translate(int dx, int dy){
		median.setLocation(median.getX() + dx, median.getY() + dy);
	}
	
	//回転角度を設定する
	public void setAngle( double a ) { angle = a; }
	
	//回転角度をthetaだけ増やす
	public void retate(double theta){
		angle += theta;
		}
	
	//拡大縮小率を再設定する
	public void setScale(double sx, double sy){
		scalex = sx; scaley = sy;
	}
	
	//現在の拡大縮小率から相対的な拡大縮小率を設定する
	public void scale(double sx, double sy){
		scalex *= sx; scaley *= sy;
	}
	
}
