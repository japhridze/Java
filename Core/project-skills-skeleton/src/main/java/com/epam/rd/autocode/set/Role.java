package com.epam.rd.autocode.set;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

public class Role {

	private final Position position;
	private final Level level;
	private final Set<Skill> skills;

	public Role(Position position, Level level, Skill... skills) {
		this.position = position;
		this.level = level;
		this.skills = EnumSet.noneOf(Skill.class);
		if (skills != null) {
			this.skills.addAll(Arrays.asList(skills));
		}
	}

	public Position getPosition() {
		return position;
	}

	public Level getLevel() {
		return level;
	}

	public Set<Skill> getSkills() {
		return skills;
	}
}