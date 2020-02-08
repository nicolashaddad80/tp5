package fr.cnam.tp5;
/**
 *  _______________________________________________________________________________________<br>
 *                         NFP121:TP5 <br>
 *  Nicolas HADDAD        <br>
 *  nicolas.haddad80@gmail.com  <br>
 *  _______________________________________________________________________________________<br>
 *   La classe SetArray inplemente l'interface Set qui represente des ensembles d'entiers <br>
 *   La modelisation d'un ensemble  est represente par un tableau contenant ses entiers   <br>
 *  ______________________________________________________________________________________<br>
 */
public class SetArray implements Set {

    private int [] setList;
    private int nbElements;

    /**
     * Constructor of our set.
     * @param a_MaxSetSize initial max size of our set
     */
    public SetArray(int a_MaxSetSize){
        this.setList = new int[a_MaxSetSize];
        this.nbElements=0;
    }

    /**
     * Retrieve the number of elements in the set.
     *
     * @return the number of elements in the set
     */
    public int cardinal(){
        return this.nbElements;
    }

    /**
     * Determine if the set is empty.
     *
     * @return true if the set is empty
     */
    public boolean isEmpty(){
        return this.nbElements==0;
    }

    /**
     * Determine if the set contains the element passed as argument.
     *
     * @param e the concerned element
     * @return true if the element is in the set
     */
    public boolean contains(int e){
        boolean l_result=false;
        int l_i=0;
        while (l_i<this.nbElements && !l_result){
            if(this.setList[l_i]==e){
                l_result=true;
            }
        l_i++;
        }
    return l_result;
    }

    /**
     * Add an element in the set.
     * If the element is present, do not do anything.
     *
     * @param e the element to add
     */
    public void add(int e){
        if(!this.contains(e)) {
            if(this.nbElements<this.setList.length ) {
                this.setList[this.nbElements] = e;
            }
            else{
                int [] l_setList=new int[this.setList.length+1];
                System.arraycopy(this.setList, 0, l_setList, 0, this.nbElements);
                l_setList[this.setList.length]=e;
                this.setList=l_setList;
            }
            this.nbElements++;
        }
    }

    /**
     * Remove an element from the set.
     * If the element is not present, do not do anything.
     *
     * @param e the element to remove
     */
    public void remove(int e){
        if (this.contains(e)){
            for (int l_i=0;l_i<this.nbElements;l_i++){

                if(this.setList[l_i]==e){
                    System.arraycopy(this.setList, l_i + 1, this.setList, l_i, this.nbElements - l_i-1);
                }
            }
            this.nbElements--;
        }
    }

    /**
     * Get the minimum of the set.
     * If the set is empty, returns 0.
     *
     * @return the smallest element of the set
     */
    public int min(){
        assert this.nbElements>0 : "the set is empty, cannot search a minimum";
        int l_min=this.setList[0];
        for (int l_i=1;l_i<this.nbElements;l_i++){

            if(this.setList[l_i]<l_min){
                l_min=this.setList[l_i];
            }
        }
    return l_min;
    }
}