package ru.pivovarov.application;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters (separators = "=")

public class Arguments {

	@Parameter ( names = {"--path"})

	public String path;

}