import java.awt.*;
import java.awt.geom.*;

// ラインを表すオブジェクトのクラス

public class DrawLine extends DrawObject {

	// 開始点の座標と終点の座標を持つ
	Point2D sp, ep;
	
	// コンストラクタ、fcは線の色を示す
	public DrawLine( double x1, double y1, double x2, double y2, Color fc ) {
		double medx = (x1 + x2) / 2.0;
		double medy = (y1 + y2) / 2.0;
		
		median = new Point2D.Double( medx, medy );
		sp = new Point2D.Double( x1-medx, y1-medy );
		ep = new Point2D.Double( x2-medx, y2-medy );
		framecolor = fc;
	}
	
	// 描画メソッド、一度GeneralPathにして、アフィン変換してから描画
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		GeneralPath  linepath = new GeneralPath( new Line2D.Double( sp, ep ));
		at = new AffineTransform( );
		at.translate( median.getX(), median.getY() );
		at.rotate( angle );
		at.scale( scalex, scaley );
		linepath.transform( at );
		if ( framecolor != null ) { g2.setColor( framecolor ); g2.draw( linepath ); }
	}
	
	// 境界領域の描画メソッド、小さな□を表示する
	public void paintBounds( Graphics g ) {
		GeneralPath  linepath = new GeneralPath( new Line2D.Double( sp, ep ));
		at = new AffineTransform( );
		at.translate( median.getX(), median.getY() );
		at.rotate( angle );
		at.scale( scalex, scaley );
		linepath.transform( at );
		Rectangle bounds = linepath.getBounds();
		g.setColor( Color.blue );
		g.drawRect( bounds.x-2, bounds.y-2, 4, 4);
		g.drawRect( bounds.x+bounds.width-2, bounds.y-2, 4, 4);
		g.drawRect( bounds.x-2, bounds.y+bounds.height-2, 4, 4);
		g.drawRect( bounds.x+bounds.width-2, bounds.y+bounds.height-2, 4, 4);
	}
	
	// 含まれているかどうか
	public boolean contains( int mx, int my ) {
		// 点と線分の距離を求める（外積を用いる）
		// http://www.deqnotes.net/acmicpc/2d_geometry/lines
		double distance;  // 距離
		double ax = ep.getX() - sp.getX();
		double ay = ep.getY() - sp.getY();
		double bx = mx - ( sp.getX()+median.getX() );
		double by = my - ( sp.getY()+median.getY() );
		double cx = mx - ( ep.getX()+median.getX() );
		double cy = my - ( ep.getY()+median.getY() );
		// sp側よりも外に出ているか
		if ( dot( ax, ay, bx, by ) < 0 ) { distance = Math.sqrt( bx*bx + by*by ); }
		// ep側よりも外に出ているか
		else if ( dot( -ax, -ay, cx, cy ) < 0 ) { distance = Math.sqrt(cx*cx + cy*cy ); }
		// spとepの間にある
		else {
			double cp = cross( ax, ay, bx, by );
			double alength = Math.sqrt( ax*ax + ay*ay);
			distance = cp / alength;
		}
		return (Math.abs( distance ) < 5 );
	}
	
	// 内積を求める関数 a・b（２次元ベクトル）
	double dot( double ax, double ay, double bx, double by ) {
		return ax * bx + ay * by;
	}
	// 外積を求める関数 | a × b |（２次元ベクトル）
	double cross( double ax, double ay, double bx, double by ) {
		return ax * by - ay * bx;
	}
}
