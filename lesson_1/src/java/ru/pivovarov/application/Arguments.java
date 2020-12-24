package ru.world.scanner;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters (separators = "=")

class Arguments {

	@Parameter ( names = {"--path"})

	public String path;

}