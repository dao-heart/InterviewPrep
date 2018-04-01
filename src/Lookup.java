/*


"SNO_FLAK_"
        "SNOWFLA__"
        "___WFL___"
        "_N_W_L_K_"
        "SNOWFLAKE"
        "_________"

public class LookUp{

    set<String> dist;
    public Lookup(set<String> dist){

        //init dist
        this.dist =  dist;


    }

    Iterator<String> getIteratorOfLen(int len)
    {

    }

    static public boolean matches(String pattern, String word)// sno_, snow
    {

        //  if(pattern.length != word.length)
        //  return false;

        for(int i = 0;i<pattern.length;i++){

            if(pattern.charAt(i)!='_'){
                if(pattern.charAt(i) != word.charAt(i))){
                    return false;
                }
            }
        }
        return true;

    }


    // "SNO_" -> SNOW, ...
    public list<String> getTheMatchingPattern(String pattern){ //wfl

        //

        list<String> output =  new ArrayList<String>();

        //Set<String> tempSet = new HashSet<String>();

        Inerator itr =  dist.getIterator();

        for(itr.hasNext())
        {
            string word = itr.next()
            if(pattern.length != word.length){
                if(matches(pattern, word)){
                    output.add(word);
                }
            }
        }


        return output;
    }
}*/
