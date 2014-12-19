import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class DrawPanel extends Panel {

	// モード
	enum Mode { Select, Edit, Rotate, Scale, Line, Rect, Oval, Star, Regular, Text, Polygon, Curve };
	Mode current = Mode.Select;  // 現在のモード
	ArrayList <DrawObject> objects; // 描画されているオブジェクト
	DrawObject  selectedObject;  	// 選択されたオブジェクト
	Color colorlist [] = { null, Color.red, Color.green, Color.blue, Color.magenta, Color.yellow, Color.cyan,
			Color.orange, Color.pink, Color.black, Color.white, Color.gray };
	Choice framecolor, fillcolor, linewidth;  // プロパティのChoice達

	// コンストラクタ
	public DrawPanel( ) {
		setBackground( new Color( 255, 255, 250 ) );
		objects = new ArrayList<DrawObject>( );
		addMouseListener( new MyMouseAdapter( ) );
		addMouseMotionListener( new MyMouseMotionAdapter( ) );
		repaint();
	}
	
	// モードを取り出す
	public Mode getMode() { return current; }
	
	// モードのセット
	public void setMode( String m ) {
		if ( m.equals( "Select") ) { current = Mode.Select; }
		else if ( m.equals( "Rotate") ) { current = Mode.Rotate; }
		else if ( m.equals( "Line" ) ) { current = Mode.Line; }
		else if ( m.equals( "Rectangle" ) ) { current = Mode.Rect; }
	}
	
	// Choiceの登録
	public void registerChoices( Choice fra, Choice fill, Choice lw ) {
		framecolor = fra; fillcolor = fill; linewidth = lw;
	}
	
	// パネルの描画
	public void paint(Graphics g) {
		// 今まで描いたオブジェクト
		for ( int i=0; i < objects.size(); i++ ) {
			objects.get( i ).paint( g );
		}
		// 現在描いているオブジェクト
		g.setColor( Color.blue );
		Graphics2D g2 = (Graphics2D)g;
		if ( currentLine != null ) { g2.draw( currentLine ); }
		if ( currentRect != null ) { g2.draw( currentRect ); }
		
		// 現在選択されているオブジェクト
		if ( selectedObject != null && current != Mode.Select && current != Mode.Rotate ) { selectedObject = null; }
		if ( selectedObject != null ) { selectedObject.paintBounds( g ); }
		if ( selectedObject != null && current == Mode.Rotate ) { selectedObject.paintMedian( g ); }
	}
	
	// マウスの入力への対処
	class MyMouseAdapter extends MouseAdapter {
		public void mousePressed( MouseEvent me ) {
			if ( getMode() == Mode.Line ) { createLine( me.getX(), me.getY() ); }
			else if ( getMode() == Mode.Rect ) { createRect( me.getX(), me.getY() ); }
			else if ( getMode() == Mode.Select || getMode() == Mode.Rotate ) { selectObject( me.getX(), me.getY() ); }
			repaint( );
		}
		
		public void mouseReleased( MouseEvent me ) {
			if ( getMode() == Mode.Line ) { registerLine( me.getX(), me.getY() ); }
			else if ( getMode() == Mode.Rect ) { registerRect( me.getX(), me.getY() ); }
			repaint( );
		}
	}
	
	class MyMouseMotionAdapter extends MouseMotionAdapter {
		public void mouseDragged( MouseEvent me ) {
			if ( current == Mode.Line ) { redrawLine( me.getX(), me.getY() ); }		
			else if ( current == Mode.Rect ) { redrawRect( me.getX(), me.getY() ); }		
			else if ( current == Mode.Select ) { moveObject( me.getX(), me.getY() ); }
			else if ( current == Mode.Rotate ) { rotateObject( me.getX(), me.getY() ); }
			repaint( );
		}
	}
	
	// 描画開始地点
	Point2D startp;
	
	// オブジェクトの選択・移動・回転
	void selectObject( int mx, int my ) {
		// 最後のオブジェクトから前に検索
		for ( int i=objects.size()-1; i >= 0; i-- ) {
			if ( objects.get( i ).contains( mx, my ) ) {
				selectedObject = objects.get( i );
				framecolor.select( searchColorIndex( selectedObject.framecolor ) );
				fillcolor.select( searchColorIndex( selectedObject.fillcolor ) );
				startp = new Point2D.Double( mx, my );
				repaint();
				return;
			}
		}
		selectedObject = null;
	}
	void moveObject( int mx, int my ) {
		if ( selectedObject == null ) { return; }
		int dx = mx - (int)(startp.getX());
		int dy = my - (int)(startp.getY());
		selectedObject.translate( dx, dy );
		startp = new Point2D.Double( mx, my );
	}
	void rotateObject( int mx, int my ) {
		if ( selectedObject == null ) { return; }
		double ax = startp.getX() - selectedObject.median.getX();
		double ay = startp.getY() - selectedObject.median.getY();
		double bx = mx - selectedObject.median.getX();
		double by = my - selectedObject.median.getY();
		double aarg = Math.atan2( ay, ax );
		double barg = Math.atan2( by, bx );
		double theta = barg - aarg;
		if ( theta < 0 ) { theta += 2*Math.PI; }
		selectedObject.setAngle( theta );
	}
	
	int searchColorIndex( Color target ) {
		for ( int i=0; i < colorlist.length; i++ ) {
			if ( colorlist[ i ] == target ) { return i; }
		}
		return 0;
	}
	// 現在描画しているライン
	Line2D currentLine;
	// Lineを作画するときのメソッド
	void createLine( int mx, int my ) {
		currentLine = new Line2D.Double( mx, my, mx, my );
		startp = new Point2D.Double( mx, my );
	}
	void redrawLine( int mx, int my ) {
		currentLine.setLine( startp.getX(), startp.getY(), mx, my );
	}
	void registerLine( int mx, int my ) {
		objects.add( new DrawLine( startp.getX(), startp.getY(), mx, my, colorlist[ framecolor.getSelectedIndex() ]));
		currentLine = null;
		startp = null;
	}
	
	// 現在描画している四角形
	Rectangle2D  currentRect;
	// Rectを作画するときのメソッド
	void createRect( int mx, int my ) {
		currentRect = new Rectangle2D.Double( mx, my, 0, 0 );
		startp = new Point2D.Double( mx, my );
	}
	void redrawRect( int mx, int my ) {
		double sx = startp.getX();
		double sy = startp.getY();
		double x = Math.min( sx, mx );
		double y = Math.min( sy, my );
		double w = Math.abs( sx - mx );
		double h = Math.abs( sy - my );
		currentRect = new Rectangle2D.Double( x, y, w, h );
	}
	void registerRect( int mx, int my ) {
		double sx = startp.getX();
		double sy = startp.getY();
		double x = Math.min( sx, mx );
		double y = Math.min( sy, my );
		double w = Math.abs( sx - mx );
		double h = Math.abs( sy - my );
		objects.add( new DrawRect( x, y, w, h, colorlist[ framecolor.getSelectedIndex() ], colorlist[ fillcolor.getSelectedIndex() ] ) );
		currentRect = null;
		startp = null;
	}
	
	// 現在描画している円
		Rectangle2D  currentOval;
	//Ovalを作画するときのメソッド
		void createOval (int mx, int my){
			
		}
		void redrawOval(int mx, int my){
			
		}
		void registerOval(int mx, int my){
			
		}
}

