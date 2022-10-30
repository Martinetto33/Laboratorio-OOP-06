/**
 * 
 */
package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     *
     * [FIELDS]
     *
     * Define any necessary field
     *
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:  think of what type of keys and values would best suit the requirements
     */
    private final Map<String, Set<U>> allFriends;
    /*
     * [CONSTRUCTORS]
     *
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     *
     * - firstName
     * - lastName
     * - username
     * - age and every other necessary field
     */
    /**
     * Builds a user participating in a social network.
     *
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        this.allFriends = new HashMap<String, Set<U>>();
    }

    /*
     * 2) Define a further constructor where the age defaults to -1
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        this(name, surname, user, -1);
    }

    /*
     * [METHODS]
     *
     * Implements the methods below
     */
    /* The following method creates a new group of followed friends with key "circle" if
    one does not already exist, then adds the user to the group. No duplicates of the 
    friends can occur due to the choice of the class "Set". 
     */
    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        if (this.allFriends.get(circle) == null) {
            this.allFriends.put(circle, new HashSet<U>());
        }
        return this.allFriends.get(circle).add(user); 
    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        Collection<U> defCopy = new HashSet<>();
        if (this.allFriends.get(groupName) != null) {
            defCopy.addAll(this.allFriends.get(groupName));
        }
        return defCopy;
    }

    @Override
    public List<U> getFollowedUsers() {
        final Set<U> defList = new HashSet<>();
        for (final String elem : this.allFriends.keySet()) {
            defList.addAll(this.allFriends.get(elem));
        }
        return new ArrayList<>(defList);
    }
}
