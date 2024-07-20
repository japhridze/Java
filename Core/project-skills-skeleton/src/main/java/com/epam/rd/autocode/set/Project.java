package com.epam.rd.autocode.set;

import java.util.*;

public class Project {
	private final List<Role> roles;

	public Project(Role... roles) {
		this.roles = new ArrayList<>(Arrays.asList(roles));
	}

	public List<Role> getRoles() {
		return roles;
	}

	public int getConformity(Set<Member> team) {
		Set<Entry> projectEntries = new HashSet<>();
		Set<Entry> teamEntries = new HashSet<>();

		for (Role role : roles) {
			for (Skill skill : role.getSkills()) {
				projectEntries.add(new Entry(role.getLevel(), skill));
			}
		}

		for (Member member : team) {
			for (Skill skill : member.getSkills()) {
				teamEntries.add(new Entry(member.getLevel(), skill));
			}
		}

		Set<Entry> commonEntries = new HashSet<>(projectEntries);
		commonEntries.retainAll(teamEntries);
		return (commonEntries.size() * 100) / projectEntries.size();
	}

	private static class Entry {
		private final Level level;
		private final Skill skill;

		Entry(Level level, Skill skill) {
			this.level = level;
			this.skill = skill;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Entry entry = (Entry) o;
			return level == entry.level && skill == entry.skill;
		}

		@Override
		public int hashCode() {
			return Objects.hash(level, skill);
		}
	}
}