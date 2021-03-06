package org.openRealmOfStars.starMap;

import org.openRealmOfStars.player.SpaceRace.SpaceRace;
import org.openRealmOfStars.player.SpaceRace.SpaceRaceUtility;

/**
 *
 * Open Realm of Stars game project
 * Copyright (C) 2016  Tuomo Untinen
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see http://www.gnu.org/licenses/
 *
 *
 * Galaxy config for creating new star map with player
 *
 */
public class GalaxyConfig {

  /**
   * Galaxy size X coordinates
   */
  private int sizeX;
  /**
   * Galaxy size Y coordinates
   */
  private int sizeY;

  /**
   * Galaxy size index in UI
   */
  private int galaxySizeIndex;

  /**
   * How many players there are
   */
  private int maxPlayers;

  /**
   * How far away solar systems are from each others
   */
  private int solarSystemDistance;

  /**
   * Sun density index in UI
   */
  private int sunDensityIndex;

  /**
   * Players start from the map border
   */
  public static final int START_POSITION_BORDER = 0;

  /**
   * Players start from random position
   */
  public static final int START_POSITION_RANDOM = 1;

  /**
   * Where players start
   */
  private int startingPosition;

  /**
   * Player races
   */
  private SpaceRace[] playerRaces;

  /**
   * Player name
   */
  private String[] playerName;

  /**
   * Chance for planetary event
   */
  private int chanceForPlanetaryEvent;

  /**
   * How many turns to get scoring victory
   */
  private int scoringVictoryTurns;
  /**
   * Constructor for galaxy config
   */
  public GalaxyConfig() {
    sizeX = 75;
    sizeY = 75;
    this.galaxySizeIndex = 1;
    setChanceForPlanetaryEvent(10);
    setScoringVictoryTurns(400);
    setMaxPlayers(4);
    setSolarSystemDistance(12, 0);
    playerRaces = new SpaceRace[StarMap.MAX_PLAYERS];
    playerName = new String[StarMap.MAX_PLAYERS];
    for (int i = 0; i < StarMap.MAX_PLAYERS; i++) {

      setRace(i, SpaceRaceUtility.getRandomRace());
      while (true) {
        String tmp = SpaceRaceUtility.getRandomName(getRace(i));
        if (isUniqueName(tmp)) {
          setPlayerName(i, tmp);
          break;
        }
      }
    }
  }

  /**
   * Is player name unique
   * @param name Unique name
   * @return True if unique
   */
  public boolean isUniqueName(final String name) {
    for (int i = 0; i < StarMap.MAX_PLAYERS; i++) {
      if (playerName[i] != null && name.equals(playerName[i])) {
        return false;
      }
    }
    return true;
  }

  /**
   * Set race for certain player
   * @param index Player index
   * @param race Space race to set
   */
  public void setRace(final int index, final SpaceRace race) {
    if (index >= 0 && index < StarMap.MAX_PLAYERS) {
      playerRaces[index] = race;
    }
  }

  /**
   * Get Space race for certain player
   * @param index Player index
   * @return SpaceRace for player
   */
  public SpaceRace getRace(final int index) {
    if (index >= 0
        && index < StarMap.MAX_PLAYERS) {
      return playerRaces[index];
    }
    return null;
  }

  /**
   * Set Player empire name
   * @param index Player Index
   * @param name Empire name
   */
  public void setPlayerName(final int index, final String name) {
    if (index >= 0 && index < StarMap.MAX_PLAYERS) {
      playerName[index] = name;
    }
  }

  /**
   * Get player empire name
   * @param index Player index
   * @return Empire name
   */
  public String getPlayerName(final int index) {
    if (index >= 0 && index < StarMap.MAX_PLAYERS) {
      return playerName[index];
    }
    return null;
  }

  /**
   * Set galaxy size. Galaxy is set for square size
   * @param size side length
   * @param galaxySize Galaxy size index in UI
   */
  public void setSize(final int size, final int galaxySize) {
    this.sizeX = size;
    this.sizeY = size;
    this.galaxySizeIndex = galaxySize;
  }

  /**
   * Get galaxy X size
   * @return Get galaxy X size
   */
  public int getSizeX() {
    return sizeX;
  }

  /**
   * Get galaxy Y size
   * @return Get galaxy Y size
   */
  public int getSizeY() {
    return sizeY;
  }

  /**
   * Get maximum players
   * @return Maximum players
   */
  public int getMaxPlayers() {
    return maxPlayers;
  }

  /**
   * Set maximum amount of players for galaxy
   * @param maxPlayers for one game
   */
  public void setMaxPlayers(final int maxPlayers) {
    if (maxPlayers >= 2 && maxPlayers <= 8) {
      this.maxPlayers = maxPlayers;
    }
  }

  /**
   * Get solary system distance
   * @return Minimum distance between solar systems
   */
  public int getSolarSystemDistance() {
    return solarSystemDistance;
  }

  /**
   * Set Solar system distance
   * @param systemDistance Actual distance between solar system
   * @param sunDensity Sun density setting in ui index
   */
  public void setSolarSystemDistance(final int systemDistance,
      final int sunDensity) {
    this.solarSystemDistance = systemDistance;
    this.sunDensityIndex = sunDensity;
  }

  /**
   * get starting position information
   * @return Starting position information
   */
  public int getStartingPosition() {
    return startingPosition;
  }

  /**
   * Set starting position. There are two choices:
   * Border and Random
   * @param startingPosition see START_POSITION_BORDER and
   *  START_POSITION_RANDOM
   */
  public void setStartingPosition(final int startingPosition) {
    this.startingPosition = startingPosition;
  }

  /**
   * Which sun density is selected from UI
   * @return Sun density index
   */
  public int getSunDensityIndex() {
    return sunDensityIndex;
  }

  /**
   * Get Galaxy size inde from ui
   * @return Galaxy size index
   */
  public int getGalaxySizeIndex() {
    return galaxySizeIndex;
  }

  /**
   * Get the chance for planetary event. Default value is 10.
   * @return the chance For PlanetaryEvent
   */
  public int getChanceForPlanetaryEvent() {
    return chanceForPlanetaryEvent;
  }

  /**
   * Set chance for planetary event. If chance 0 then
   * there won't be any planetary events. If given value is not in
   * range then it its truncated to the range.
   * @param chance Chance for planetary event between 0-100%
   */
  public void setChanceForPlanetaryEvent(final int chance) {
    if (chance < 0) {
      chanceForPlanetaryEvent = 0;
    } else if (chance > 99) {
      chanceForPlanetaryEvent = 99;
    } else {
      chanceForPlanetaryEvent = chance;
    }
  }

  /**
   * Get game playing time before scoring is done
   * for victory
   * @return the scoringVictoryTurns
   */
  public int getScoringVictoryTurns() {
    return scoringVictoryTurns;
  }

  /**
   * Set game playing time in turns. After last turn
   * scoring is done. Maximum playing time is 1000 turns and
   * minimum is 200 turns.
   * @param scoringVictoryTurns the scoringVictoryTurns to set
   */
  public void setScoringVictoryTurns(final int scoringVictoryTurns) {
    if (scoringVictoryTurns > 1000) {
      this.scoringVictoryTurns = 1000;
    } else if (scoringVictoryTurns < 200) {
      this.scoringVictoryTurns = 200;
    } else {
      this.scoringVictoryTurns = scoringVictoryTurns;
    }
  }

}
