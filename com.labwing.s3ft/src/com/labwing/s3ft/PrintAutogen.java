
package com.labwing.s3ft;

import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.strings.Strings;
import com.jfixby.scarabei.api.sys.settings.ExecutionMode;
import com.jfixby.scarabei.api.sys.settings.SystemSettings;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class PrintAutogen {

	public static void main (final String[] args) {

		ScarabeiDesktop.deploy();
		SystemSettings.setExecutionMode(ExecutionMode.PUBLIC_RELEASE);
		final String list = "                                   com.labwing.jutil.ScanForAutogen.lambda$0(ScanForAutogen.java:23)| D:\\LabWing\\Labs-of-Time\\Labs-of-Time\\LabsOfTime.Crm.Dynamics\\Domain\\LabWingSdkTypes.cs\r\n"
			+ "                                   com.labwing.jutil.ScanForAutogen.lambda$0(ScanForAutogen.java:23)| D:\\LabWing\\Labs-of-Time\\Labs-of-Time\\LabsOfTime.Crm.Dynamics\\Domain\\Utility\\OptionSets.cs\r\n"
			+ "                                   com.labwing.jutil.ScanForAutogen.lambda$0(ScanForAutogen.java:23)| D:\\LabWing\\Labs-of-Time\\Labs-of-Time\\LabCarrier.WingControl\\Webserver\\Cassini.Gui\\Properties\\Resources.Designer.cs\r\n"
			+ "                                   com.labwing.jutil.ScanForAutogen.lambda$0(ScanForAutogen.java:23)| D:\\LabWing\\Labs-of-Time\\Labs-of-Time\\LabCarrier.WingControl\\Webserver\\Cassini.Gui\\Properties\\Settings.Designer.cs\r\n"
			+ "                                   com.labwing.jutil.ScanForAutogen.lambda$0(ScanForAutogen.java:23)| D:\\LabWing\\Labs-of-Time\\Labs-of-Time\\LabsOfTime.Middleware.CSH\\obj\\Debug\\net452\\LabsOfTime.Middleware.CSH.AssemblyInfo.cs\r\n"
			+ "                                   com.labwing.jutil.ScanForAutogen.lambda$0(ScanForAutogen.java:23)| D:\\LabWing\\Labs-of-Time\\Labs-of-Time\\LabsOfTime.LabApp\\LabApp3.0\\API\\Connected Services\\LabWingWebService\\Reference.cs\r\n"
			+ "                                   com.labwing.jutil.ScanForAutogen.lambda$0(ScanForAutogen.java:23)| D:\\LabWing\\Labs-of-Time\\Labs-of-Time\\LabsOfTime.LabApp\\LabApp3.0\\LabApp\\LabApp.Android\\Resources\\Resource.designer.cs\r\n"
			+ "                                   com.labwing.jutil.ScanForAutogen.lambda$0(ScanForAutogen.java:23)| D:\\LabWing\\Labs-of-Time\\Labs-of-Time\\LabsOfTime.LogisticsHub\\LabsOfTime.LogisticsHub.Core\\obj\\Debug\\net452\\LabsOfTime.LogisticsHub.Core.AssemblyInfo.cs\r\n"
			+ "                                   com.labwing.jutil.ScanForAutogen.lambda$0(ScanForAutogen.java:23)| D:\\LabWing\\Labs-of-Time\\Labs-of-Time\\LabsOfTime.LogisticsHub\\LabsOfTime.LogisticsHub.Core\\obj\\Debug\\net48\\LabsOfTime.LogisticsHub.Core.AssemblyInfo.cs\r\n"
			+ "                                   com.labwing.jutil.ScanForAutogen.lambda$0(ScanForAutogen.java:23)| D:\\LabWing\\Labs-of-Time\\Labs-of-Time\\LabsOfTime.LogisticsHub\\LabsOfTime.LogisticsHub.CSHTest\\obj\\Debug\\net472\\LabsOfTime.LogisticsHub.CSHTest.AssemblyInfo.cs\r\n"
			+ "                                   com.labwing.jutil.ScanForAutogen.lambda$0(ScanForAutogen.java:23)| D:\\LabWing\\Labs-of-Time\\Labs-of-Time\\LabsOfTime.LogisticsHub\\LabsOfTime.LogisticsHub.Data\\obj\\Debug\\net452\\LabsOfTime.LogisticsHub.Data.AssemblyInfo.cs\r\n"
			+ "                                   com.labwing.jutil.ScanForAutogen.lambda$0(ScanForAutogen.java:23)| D:\\LabWing\\Labs-of-Time\\Labs-of-Time\\LabsOfTime.LogisticsHub\\LabsOfTime.LogisticsHub.Data\\obj\\Debug\\net472\\LabsOfTime.LogisticsHub.Data.AssemblyInfo.cs\r\n"
			+ "                                   com.labwing.jutil.ScanForAutogen.lambda$0(ScanForAutogen.java:23)| D:\\LabWing\\Labs-of-Time\\Labs-of-Time\\LabsOfTime.LogisticsHub\\LabsOfTime.LogisticsHub.Data\\obj\\Debug\\net48\\LabsOfTime.LogisticsHub.Data.AssemblyInfo.cs\r\n"
			+ "                                   com.labwing.jutil.ScanForAutogen.lambda$0(ScanForAutogen.java:23)| D:\\LabWing\\Labs-of-Time\\Labs-of-Time\\LabsOfTime.LabApp\\LabApp3.0\\API\\obj\\Debug\\netstandard2.0\\LabsOfTime.LabApp.API.AssemblyInfo.cs\r\n"
			+ "                                   com.labwing.jutil.ScanForAutogen.lambda$0(ScanForAutogen.java:23)| D:\\LabWing\\Labs-of-Time\\Labs-of-Time\\LabsOfTime.LabApp\\LabApp3.0\\API\\obj\\Release\\netstandard2.0\\LabsOfTime.LabApp.API.AssemblyInfo.cs\r\n"
			+ "";
		final String pref = "                                   com.labwing.jutil.ScanForAutogen.lambda$0(ScanForAutogen.java:23)| D:\\LabWing\\Labs-of-Time\\Labs-of-Time\\";
		final List<String> l = Strings.split(list, "\r\n");
		for (final String s : l) {

			String sub = s.substring(pref.length());
			sub = sub.replaceAll("\\\\", "/");
			L.d(sub);
		}

	}

}
