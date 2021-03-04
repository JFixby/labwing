
package com.labwing.s3ft;

import java.io.IOException;

import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.FileConflistResolver;
import com.jfixby.scarabei.api.file.FileFilter;
import com.jfixby.scarabei.api.file.FileSystem;
import com.jfixby.scarabei.api.file.FilesList;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.sys.settings.ExecutionMode;
import com.jfixby.scarabei.api.sys.settings.SystemSettings;
import com.jfixby.scarabei.api.util.Utils;
import com.jfixby.scarabei.aws.api.AWSCredentialsViaSystemSettingsProvider;
import com.jfixby.scarabei.aws.api.s3.S3;
import com.jfixby.scarabei.aws.api.s3.S3FileSystem;
import com.jfixby.scarabei.aws.api.s3.S3FileSystemConfig;
import com.jfixby.scarabei.aws.desktop.s3.DesktopS3;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class UploadToCloud {

	public static void main (final String[] args) throws IOException {

		ScarabeiDesktop.deploy();
		SystemSettings.setExecutionMode(ExecutionMode.PUBLIC_RELEASE);

		S3.installComponent(new DesktopS3());

		final File labsOfTime = LocalFileSystem.newFile("D:\\LabWing\\Labs-of-Time\\Labs-of-Time");

		final S3FileSystemConfig s3fscfg = S3.invoke().newFileSystemConfig();

		s3fscfg.bucketName = "labwing";
		s3fscfg.awsCredentialsProvider = new AWSCredentialsViaSystemSettingsProvider();

		final S3FileSystem fs = S3.invoke().newFileSystem(s3fscfg);
		final File s3root = fs.ROOT();
		s3root.clearFolder();
		final File uploadFolder = s3root.proceed(Utils.newRelativePath("LabWing/Labs-of-Time/Labs-of-Time"));
		uploadFolder.makeFolder();
// final FilesList list = s3root.listAllChildren();
// L.d("uploadFolder", uploadFolder);

		upload(labsOfTime, uploadFolder);

	}

	private static void upload (final File local, final File remote) throws IOException {
		final FileSystem fs = local.getFileSystem();

// local.listDirectChildren()

		final List<String> ignoredFiles = LabWingCloud.listIgnoredFiles();
		final List<String> ignoredExtentions = LabWingCloud.listIgnoredExtentions();
		final List<String> includedExtentions = LabWingCloud.listIncludedExtentions();
		final List<File> autogeneratedFiles = LabWingCloud.listAutogeneratedFiles();

		final FileFilter pdfFileFilter = new FileFilter() {
			@Override
			public boolean fits (final File f) {
				if (!includedExtentions.contains(f.getExtension())) {
					return false;
				}
				if (autogeneratedFiles.contains(f)) {
					return false;
				}
				return true;
			}
		};

		final FilesList files_list = local.listAllChildren(pdfFileFilter);
		final FileConflistResolver resollver = new FileConflistResolver() {

			@Override
			public boolean overwrite (final File fileToCopy, final File existing) throws IOException {
				return OVERWRITE_ON_HASH_MISMATCH.overwrite(fileToCopy, existing);
			}
		};

		for (final File f : files_list) {

			fs.copyFileToFolder(f, remote, resollver);
		}

	}

}
