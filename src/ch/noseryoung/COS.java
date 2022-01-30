package ch.noseryoung;

/**
 * An interface used to define a condition of survival, which
 * is then used to evaluate the replication
 */
public interface COS {
    boolean conditionForSurvival(Organism organism);
}
