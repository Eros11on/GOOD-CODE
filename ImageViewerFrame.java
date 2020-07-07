import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class ImageViewer
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new ImageViewerFrame();
				frame.setTitle("ImageViewer");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}


class ImageViewerFrame extends JFrame
{
	private JLabel label; //标签label用于显示选中的图片
	private JFileChooser chooser; //图片选择器chooser
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	public ImageViewerFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		//添加标签
		label = new JLabel(); 
		add(label);
		
		//设置选择器
		chooser = new JFileChooser(); 
		chooser.setCurrentDirectory(new File("."));
		
		//设置标题栏
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new ActionListener() //设置“Open"事件监听器
		{
			public void actionPerformed(ActionEvent event)
			{
				//显示图片选择对话框
				int result = chooser.showOpenDialog(null);
				
				//如果有图片被选中，在label中显示它
				if(result == JFileChooser.APPROVE_OPTION)
				{
					String name = chooser.getSelectedFile().getPath();
					label.setIcon(new ImageIcon(name));
				}
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener() //设置”Exit“事件监听器
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
	}
}

