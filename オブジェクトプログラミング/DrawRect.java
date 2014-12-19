import java.awt.*;
import java.awt.geom.*;

// 四角形を表すオブジェクトのクラス

public class DrawRect extends DrawObject {
	// 幅と高さの情報を余分に持つ
	double width;
	double height;
	
	// コンストラクタ、枠の色と塗り潰しの色を持つ
	public DrawRect( double x, double y, double w, double h, Color fr, Color fill ) {
		median = new Point2D.Double( x+w/2, y+h/2 );
		width = w;
		height = h;
		framecolor = fr;
		fillcolor = fill;
	}
	
	// 描画メソッド
	// 一度Areaクラスのオブジェクトにして、アフィン変換してから描画
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		Area  rectarea = new Area( new Rectangle2D.Double( -width/2, -height/2, width, height) );
		at = new AffineTransform();
		at.translate( median.getX(), median.getY() );
		at.rotate( angle );
		at.scale( scalex, scaley );
		rectarea.transform( at );
		if ( fillcolor != null ) { g2.setColor( fillcolor ); g2.fill( rectarea ); }
		if ( framecolor != null ) { g2.setColor( framecolor ); g2.draw( rectarea ); }
	}
	
	// 境界領域を示す４つの□を表示する
	public void paintBounds( Graphics g ) {
		Area  rectarea = new Area( new Rectangle2D.Double( -width/2, -height/2, width, height) );
		at = new AffineTransform();
		at.translate( median.getX(), median.getY() );
		at.rotate( angle );
		at.scale( scalex, scaley );
		rectarea.transform( at );
		Rectangle bounds = rectarea.getBounds();
		g.setColor( Color.blue );
		g.drawRect( bounds.x-2, bounds.y-2, 4, 4);
		g.drawRect( bounds.x+bounds.width-2, bounds.y-2, 4, 4);
		g.drawRect( bounds.x-2, bounds.y+bounds.height-2, 4, 4);
		g.drawRect( bounds.x+bounds.width-2, bounds.y+bounds.height-2, 4, 4);
	}
	
	// 指定された点が含まれているかどうか
	public boolean contains( int mx, int my ) {
		Rectangle2D rect = new Rectangle2D.Double(
				median.getX()-width/2, median.getY()-height/2, width, height);
		return rect.contains( mx, my );
	}
}
