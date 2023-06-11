#include <vector>
using namespace std;

class SnapshotArray
{
public:
    SnapshotArray(int length)
    {
        curr_snap_id = 0;
        records.resize(length);
        for (int i = 0; i < length; i++)
        {
            records[i].push_back(make_pair(0, 0));
        }
    }

    void set(int index, int val)
    {
        records[index].push_back(make_pair(curr_snap_id, val));
    }

    int snap()
    {
        return curr_snap_id++;
    }

    int get(int index, int snap_id)
    {
        auto it = upper_bound(records[index].begin(),
                              records[index].end(),
                              make_pair(snap_id, INT_MAX));
        return prev(it)->second;
    }

private:
    int curr_snap_id;
    vector<vector<pair<int, int>>> records;
};