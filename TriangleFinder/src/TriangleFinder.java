import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.canvas.*;
import javafx.scene.control.ScrollPane.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.shape.*;
import java.io.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.*;
import javafx.scene.paint.*;
public class TriangleFinder extends Application
{
	Group root = new Group();
	Scene mainScene = new Scene(root, 610, 610, Color.WHITESMOKE);
	
	TextField[] inputs = new TextField[5];
	/*
	 *
	 * 0=bottom right angle
	 * 1=top left angle
	 * 2=hypotenuse
	 * 3=bottom side
	 * 4=left side
	 *
	 */
	public static void main(String[] args)
	{
		launch(args);
	}
	@Override
	public void start(Stage mainStage) throws Exception
	{
		//add buttons

		Button clearBut = new Button("Clear");
		Button solveBut = new Button("Solve");	
		clearBut.setPrefSize(50,20);
		solveBut.setPrefSize(50,20);
		
		solveBut.relocate(250,580);
		clearBut.relocate(315,580);
		root.getChildren().addAll(solveBut,clearBut);
		solveBut.setOnAction(e->solve());
		clearBut.setOnAction(e->reset());
		for(int i =0; i<=4; i++)
		{
			inputs[i] = new TextField();
			root.getChildren().add(inputs[i]);
		}
		//Draw triangle
		Line hypotenuse = new Line(100,50,550,500);
		Line base = new Line(550,500,100,500);
		Line height = new Line(100,500,100,50);
		base.setFill(Color.DARKBLUE);
		height.setFill(Color.DARKBLUE);
		hypotenuse.setFill(Color.DARKBLUE);
		root.getChildren().addAll(hypotenuse,base,height);
		//create input boxes
		inputs[0].setPrefColumnCount(5);
		inputs[0].setPromptText("Input angle");
		inputs[0].setLayoutX(425 - inputs[0].getLayoutBounds().getMinX());
		inputs[0].setLayoutY(450- inputs[0].getLayoutBounds().getMinY());
		inputs[0].setRotate(315);
		
		inputs[1].setPrefColumnCount(5);
		inputs[1].setPromptText("Input angle");
		inputs[1].setLayoutX(100 - inputs[1].getLayoutBounds().getMinX());
		inputs[1].setLayoutY(140 - inputs[1].getLayoutBounds().getMinY());
		inputs[1].setRotate(315);
		
		inputs[2].setPrefColumnCount(9);
		inputs[2].setPromptText("enter hypotenuse");
		inputs[2].setLayoutX(280- inputs[2].getLayoutBounds().getMinX());
		inputs[2].setLayoutY(255- inputs[2].getLayoutBounds().getMinY());
		inputs[2].setRotate(45);
		
		inputs[3].setPrefColumnCount(9);
		inputs[3].setPromptText("Input Base");
		inputs[3].setLayoutX(250 - inputs[3].getLayoutBounds().getMinX());
		inputs[3].setLayoutY(502 - inputs[3].getLayoutBounds().getMinY());

		inputs[4].setPrefColumnCount(9);
		inputs[4].setPromptText("Input height");
		inputs[4].setLayoutX(20 - inputs[4].getLayoutBounds().getMinX());
		inputs[4].setLayoutY(300 - inputs[4].getLayoutBounds().getMinY());
		inputs[4].setRotate(90);

		mainStage.setScene(mainScene);
		mainStage.show();
	}
	public void solve()
	{
		int check=0;
		boolean failed = false;
		double[] numbs = new double[5];
		for (int i =0; i<=4; i++)
		{
			if(!failed)
			{
				inputs[i].setEditable(false);
				try
				{
				numbs[i] = Double.parseDouble(inputs[i].getText());
				if (numbs[i]<0)
				{
					check++;
					numbs[i]=0;
				}
				}
				catch(java.lang.NumberFormatException jlNFE109)
				{
					if (!inputs[i].getText().equals("")||inputs[i].getText()==null)
					{
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR");
					alert.setHeaderText(null);
					alert.setContentText("Please enter only numbers");
					
					alert.showAndWait();
					failed = true;
					inputs[i].setEditable(true);
					}
					else 
					{
						numbs[i]=0;
						check++;
					}
				}
			}

		}
		if (check>3)
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText(null);
			alert.setContentText("Please enter more than one number");
			alert.showAndWait();
			
			reset();
			failed=true;			
		}
		if (!failed)
		{
			TriangleSolver hello = new TriangleSolver(numbs);
			numbs = hello.getResults();
			for(int i =0; i<5; i++)
			{
				inputs[i].setText(" "+numbs[i]);
			}
		}
	}
	public void reset()
	{
		for (int i =0; i<=4; i++)
		{
			inputs[i].setEditable(true);
			inputs[i].setText("");
		}
	}
}