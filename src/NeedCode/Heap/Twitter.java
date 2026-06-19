package NeedCode.Heap;

import java.util.*;

public class Twitter {

    private class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private int time = 0;

    Map<Integer, Set<Integer>> subscriptionList = new HashMap<>();
    Map<Integer, List<Tweet>> usersTweets = new HashMap<>();

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        usersTweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        var userTweets = usersTweets.get(userId);
        PriorityQueue<Tweet> heap = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));
        if (userTweets != null) {
            for (Tweet tweet : userTweets) {
                heap.offer(tweet);
            }
        }
        var subs = subscriptionList.get(userId);
        if (subs != null) {
            for (int subId : subs) {
                List<Tweet> subTweets = usersTweets.get(subId);
                if (subTweets != null) {
                    for (Tweet tweet : subTweets) {
                        heap.offer(tweet);
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (result.size() < 10 && !heap.isEmpty()) {
            result.add(heap.poll().id);
        }

        return result;
    }


    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        subscriptionList.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> subs = subscriptionList.get(followerId);
        if (subs != null && followerId != followeeId) {
            subs.remove(followeeId);
        }
    }
}
