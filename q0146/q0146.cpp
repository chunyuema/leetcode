class LRUCache
{
    int capacity;
    list<int> keys;
    unordered_map<int, pair<int, list<int>::iterator>> map;

public:
    LRUCache(int capacity) : capacity(capacity) {}

    int get(int key)
    {
        if (map.find(key) != map.end())
        {
            // erase the old key position, and push it to the front of list to indicate that it is used most recently
            keys.erase(map[key].second);
            keys.push_front(key);

            // update the key's position in the map to indicate that it was used most recently
            map[key].second = keys.begin();
            return map[key].first;
        }
        return -1;
    }

    void put(int key, int value)
    {
        // if the key already exists, replace its value:
        // erase the old key position
        if (map.find(key) != map.end())
        {
            keys.erase(map[key].second);
        }

        // if the key does not exist, but the capacity is max-ed out
        // erase the oldest key
        else if (keys.size() == capacity)
        {
            map.erase(keys.back());
            keys.pop_back();
        }

        // add the current key to the front, and update the value and position of the key accordingly
        keys.push_front(key);
        map[key] = {value, keys.begin()};
    }
};