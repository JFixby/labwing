
package com.labwing.s3ft;

import java.io.IOException;

import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.FilesList;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.sys.settings.ExecutionMode;
import com.jfixby.scarabei.api.sys.settings.SystemSettings;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class ScanForAutogen {

	public static void main (final String[] args) throws IOException {
		ScarabeiDesktop.deploy();
		SystemSettings.setExecutionMode(ExecutionMode.PUBLIC_RELEASE);
		final File labsOfTime = LocalFileSystem.newFile("D:\\LabWing\\Labs-of-Time\\Labs-of-Time");
		final FilesList list = labsOfTime.listAllChildren(file -> {
			if (file.extensionIs("cs") || file.extensionIs("vb")) {
				try {
					final String data = file.readToString();
					if (data.contains("// <auto-generated>")) {
						L.d(file.toJavaFile().toString());
						return true;
					}

				} catch (final IOException e) {
					e.printStackTrace();
				}

			}

			return false;
		});
// L.d("list", list);

	}

}
