package demo07test;

public class Hero {
    private String name;
    private Skill skill;

    public Hero() {
    }

    public Hero(String name, Skill skill) {
        this.name = name;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
    public void attack(){
        System.out.println("我叫"+getName()+",开始释放技能");
        skill.use();
        System.out.println("技能释放完成");
    }
}
