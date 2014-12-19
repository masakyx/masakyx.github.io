import java.awt.*;
import java.awt.event.*;

// 全体のアプリケーションのクラス

public class DrawApp extends Frame {


	// 動作モードを選ぶChoice
	String  mode [] = { "Select", "Rotate", "Line", "Rectangle", "Oval" }; 
	Choice modeselector;
	
	// カラー名のリスト、Noneは描画しないことを示す
	String colornamelist [ ] = { "None", "Red", "Green", "Blue", "Magenta","Yellow", "Cyan", 
			"Orange", "Pink", "Black", "White", "Gray" };
	Choice  framecolor; 	// フレームカラーを選ぶChoice
	Choice  fillcolor; // 塗りつぶしカラーを選ぶChoice

	// ラインの太さのリスト
	String  widthlist [ ]= { "0.5", "1", "2", "3", "4" };
	Choice linewidth;
	
	// モードやプロパティを示すパネル
	Panel  bar;
	
	// ドローのパネル
	DrawPanel drawpanel;
	
	// mainメソッド
	public static void main(String[] arg) {
		new DrawApp( );
	}

	// コンストラクタ
	public DrawApp( ) {
		// ウィンドウの設定
		super( "Draw Application" );
		setSize( 800, 600 );
		addWindowListener( new DrawWindowAdapter( ) );
		setLayout( new BorderLayout( ) );
		
		// ドローパネル初期化
		drawpanel = new DrawPanel( );
		add( "Center",  drawpanel );
		
		// ツール、プロパティの表示のパネル初期化
		bar = new Panel();
		
		// モード選択の初期化
		modeselector = new Choice( );
		for ( int i=0; i < mode.length; i++ ) {
			modeselector.add( mode[ i ] );
		}
		modeselector.addItemListener( new MyItemAdapter() );
		bar.add( new Label( "Mode:") );
		bar.add( modeselector );
		
		// カラー選択の初期化
		framecolor = new Choice( );
		fillcolor = new Choice();
		for ( int i=0; i < colornamelist.length; i++ ) {
			framecolor.add( colornamelist[ i ] );
			fillcolor.add( colornamelist[ i ] );
		}
		framecolor.select( "Black" );
		framecolor.addItemListener( new MyItemAdapter() );
		fillcolor.addItemListener( new MyItemAdapter() );
		bar.add( new Label( "Frame:") );
		bar.add( framecolor );
		bar.add( new Label( "Fill:") );
		bar.add( fillcolor );
		
		// 線の太さの初期化
		linewidth = new Choice();
		for ( int i=0; i < widthlist.length; i++ ) {
			linewidth.add( widthlist[ i ] );
		}
		linewidth.select( "1" );
		bar.add( new Label( "LineWidth:") );
		bar.add( linewidth );
		
		add( "North", bar );
		
		// Choiceをdrawpanelに登録（選択されたときに、自動的に項目が変わるように）
		drawpanel.registerChoices( framecolor, fillcolor, linewidth );
		setVisible( true );
	}
	
	// 選択の対処
	class MyItemAdapter implements ItemListener {
		public void itemStateChanged( ItemEvent ie ) {
			if ( ie.getSource() == modeselector ) {
				drawpanel.setMode( modeselector.getSelectedItem() );
			} else if ( ie.getSource() == framecolor ) {
			} else if ( ie.getSource() == fillcolor ) {
			} else if ( ie.getSource() == linewidth ) {
			}
		}
	}
	// ウィンドウアダプター
	class DrawWindowAdapter extends WindowAdapter {
		// ウィンドウを消すときに呼ばれる
		public void windowClosing( WindowEvent we ) {
			setVisible( false );
			dispose();
		}
		// ウィンドウを消した後に呼ばれる
		public void windowClosed( WindowEvent we ) {
			System.exit( 0 );
		}
	}
}
