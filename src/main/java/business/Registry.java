package business;

/**
 *  <p>
 *      Registry stores info about (registered) interfaces implementations.
 *      Represents implementation of the service locator pattern
 *  </p>
 *  <p>
 *      Concept of registry:
 *      <ul>
 *          <li><Registry SHOULD be an enum with static field getDefault()/li>
 *          <li>Each registry entry MUST be also a name of the single implementation</li>
 *          <li>Each registry entry MUST have toString() that returns implementation (class implementing given interface) name</li>
 *      </ul>
 *  </p>
 */

public interface Registry {}
