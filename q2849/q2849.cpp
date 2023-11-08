class Solution
{
public:
    bool isReachableAtTime(int sx, int sy, int fx, int fy, int t)
    {
        const int xDist = abs(fx - sx);
        const int yDist = abs(fy - sy);

        // if start is also end, but you need to move only once => impossible
        if (xDist == 0 && yDist == 0 && t == 1)
            return false;

        // as long as total time t is larget than the shortest time needed => possible
        // note that we can just move around to waste time before landing on the destination
        return t >= max(xDist, yDist);
    }
};