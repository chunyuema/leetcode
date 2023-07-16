class Solution
{
public:
    vector<int> smallestSufficientTeam(vector<string> &req_skills, vector<vector<string>> &people)
    {
        const int n = req_skills.size();

        // build a bit representation of the skills different people have
        vector<int> peopleSkillsInBits;
        for (const auto &p : people)
        {
            int personBitMask = 0;
            for (const string &s : p)
            {
                int reqSkillIndex = find(req_skills.begin(), req_skills.end(), s) - req_skills.begin();
                personBitMask |= (1 << reqSkillIndex);
            }
            peopleSkillsInBits.push_back(personBitMask);
        }

        // memo[skillComposition] represents the smallest sufficient team to achieve the skillComposition
        // since skill composition is represented in binary, all 0s represent no skills fulfilled
        // and all 1s represent all skills fulfilled.
        unordered_map<int, vector<int>> memo;
        memo[0] = {};

        for (int i = 0; i < people.size(); i++)
        {
            unordered_map<int, vector<int>> tmp(memo);
            // check all the skill composition we have had before
            for (const auto &kv : memo)
            {
                int oldSkillComposition = kv.first;
                int oldTeamSize = kv.second.size();
                int newSkillComposition = oldSkillComposition | peopleSkillsInBits[i];
                int newTeamSize = oldTeamSize + 1;

                // update the map if the newSkillComposition has never appeared before
                // update the map if the newTeamSize is better than the previously registered team size
                if (!tmp.count(newSkillComposition) || tmp[newSkillComposition].size() > newTeamSize)
                {
                    // record the people needed on the team
                    tmp[newSkillComposition] = kv.second;
                    tmp[newSkillComposition].push_back(i);
                }
            }
            tmp.swap(memo);
        }
        // return the ans as all 1s representing all required skills fulfilled
        return memo[(1 << n) - 1];
    }
};