package io.sloeber.providers;

import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import io.sloeber.core.Examples;
import io.sloeber.core.api.PackageManager;

@SuppressWarnings("nls")
public class Jantje extends MCUBoard {



	public static String getJsonFileName() {
		return  "package_jantje_index.json";
	}
	public static String getPackageName() {
		return "Jantje";
	}
	public static String getPlatformName() {
		return "Arduino avr Boards (local debug)";
	}
	public Jantje(String boardName) {
		Map<String, String> options = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		options.put("type", "debug");
		this.myBoardDescriptor = PackageManager.getBoardDescriptor(getJsonFileName(),getPackageName(),getPlatformName() ,
				boardName, options);
		if (this.myBoardDescriptor == null) {
			fail(boardName + " Board not found");
		}
		this.myBoardDescriptor.setUploadPort("none");

		myAttributes.serial=!Arduino.doesNotSupportSerialList().contains(boardName);
		myAttributes.serial1=Arduino.supportSerial1List().contains(boardName);
		myAttributes.keyboard=Arduino.supportKeyboardList().contains(boardName);
	}
    @Override
    public boolean isExampleSupported(Examples example) {
        LinkedList<String> notSupportedExamples = new LinkedList<>();
        notSupportedExamples.add("Example/09.USB/Keyboard/KeyboardLogout");
        notSupportedExamples.add("Example/09.USB/Keyboard/KeyboardMessage");
        notSupportedExamples.add("Example/09.USB/Keyboard/KeyboardReprogram");
        notSupportedExamples.add("Example/09.USB/Keyboard/KeyboardSerial");
        notSupportedExamples.add("Example/09.USB/KeyboardAndMouseControl");
        notSupportedExamples.add("Example/09.USB/Mouse/ButtonMouseControl");
        notSupportedExamples.add("Example/09.USB/Mouse/JoystickMouseControl");
        notSupportedExamples.add("Example/10.StarterKit_BasicKit/p13_TouchSensorLamp");
      if(  notSupportedExamples.contains(example.getFQN())) {
          return false;
      }
        return super.isExampleSupported(example);
    }

    public static MCUBoard[] getAllBoards() {
    	//hardcode this stuff now because I want to release 4.3.1
    	//shoulds be something like 
        //return PackageManager.getAllBoardDescriptors(getJsonFileName(),getPackageName(),getPlatformName() , options);
    	MCUBoard[] boards = {  new Jantje("yun"),new Jantje("uno"),new Jantje("diecimila"),new Jantje("nano"),new Jantje("mega"),new Jantje("megaADK"),new Jantje("leonardo"),new Jantje("micro"),
        		new Jantje("esplora"),new Jantje("mini"),new Jantje("ethernet"),new Jantje("fio"),new Jantje("bt"),new Jantje("LilyPadUSB"),new Jantje("lilypad"),new Jantje("pro"),
        		new Jantje("atmegang"),new Jantje("robotControl") };
		return boards;
   			


    }

}
