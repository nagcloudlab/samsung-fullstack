


<template>
  <div>
    <!-- binding text -->
    <div>{{ message }} by {{ name }}</div>
    <!-- binding html -->
    <div v-html="htmlMarkup"></div>
    <div v-html="hack"></div>
    <!-- binding attributes -->
    <div :id="'todo-' + todoId">Todo</div>
    <button :disabled="!isAvailable">Click me</button>
    <!-- binding class -->
    <h2 class="underline">Underlined Text</h2>
    <h2 :class="status">Status</h2>
    <h2 class="underline" :class="status">Static Dynamic</h2>
    <h2 :class="isPromoted && 'promoted'">Promoted Movie</h2>
    <h2 :class="isSoldOut ? 'sold-out' : 'new'">Soldout? Movie</h2>
    <h2 :class="['new', 'promoted']">Newly Promoted Movie</h2>
    <h2 :class="[isPromoted && 'promoted', isSoldOut ? 'sold-out' : 'new']">
      Array Conditional Movie
    </h2>
    <h2
      :class="{
        promoted: isPromoted,
        new: !isSoldOut,
        'sold-out': isSoldOut,
      }"
    >
      Object Conditional Movie
    </h2>
    <!-- binding inline-style -->
    <h2
      v-bind:style="{
        color: highlightColor,
        fontSize: headerSize + 'px',
        padding: '20px',
      }"
    >
      Inline Style
    </h2>
    <h2 :style="headerStyleObject">Style Object</h2>
    <div :style="[baseStyleObject, successStyleObject]">Success Style</div>
    <div :style="[baseStyleObject, dangerStyleObject]">Danger Style</div>

    <!-- conditional rendering -->
    <h1 v-if="num === 0">The number is zero</h1>
    <h2 v-else-if="num < 0">The number is negative</h2>
    <h2 v-else-if="num > 0">The number is positive</h2>
    <h2 v-else>Not a number</h2>

    <template v-if="isAvailable">
      <h1>laptop</h1>
      <h2>100.00</h2>
    </template>
    <h1 v-show="false">v-show</h1>

    <!-- list rendering -->
    <h2 v-for="(name, index) in names" :key="name">{{ index }} {{ name }}</h2>
    <h2 v-for="name in fullNames" :key="name.first">
      {{ name.first }} {{ name.last }}
    </h2>
    <div v-for="actor in actors" :key="actor.name">
      <h2>{{ actor.name }}</h2>
      <h3 v-for="movie in actor.movies" :key="movie">{{ movie }}</h3>
    </div>
    <h2 v-for="(value, key, index) in myInfo" :key="value">
      {{ index }} {{ key }} {{ value }}
    </h2>
    <div v-for="name in names" :key="name">
      <h2 v-if="name === 'nag'">{{ name }}</h2>
    </div>

    <!-- methods -->
    <h2>{{ 2 + 3 + 5 }}</h2>
    <h2>{{ 5 + 10 + 15 }}</h2>
    <h2>Add method - {{ add(2, 3, 5) }}</h2>
    <h2>Add method - {{ add(5, 10, 15) }}</h2>
    <h2>Multiply method - {{ multiply(10) }}</h2>
    <h2>Multiply method - {{ multiply(baseValue) }}</h2>

    <!-- event handling -->
    <h1>{{ name }}</h1>
    <div>
      <!-- <button v-on:click="changeName($event, 'foo')">Change name</button>
       -->
      <button @click="changeName($event, 'foo')">Change name</button>
      <h2>{{ count }}</h2>
      <div>
        <button @click="increment(1, $event)">Increment</button>
        <button @click="decrement(1)">Decrement</button>
        <button @click="increment(5)">Increment 5</button>
        <button @click="decrement(5)">Decrement 5</button>
      </div>
    </div>
    <hr />
    <!-- form handling -->
    <div>
      <pre>
      {{ JSON.stringify(formValues, null, 2) }}
    </pre
      >
    </div>
    <form>
      <div>
        <label for="name">Name</label>
        <input type="text" id="name" v-model.trim="formValues.name" />
      </div>
      <div>
        <label for="profile">Profile Summary</label>
        <textarea id="profile" v-model="formValues.profileSummary" />
      </div>
      <div>
        <label for="country">Country</label>
        <select id="country" v-model="formValues.country">
          <option value="">Select a country</option>
          <option value="india">India</option>
          <option value="vietnam">Vietnam</option>
          <option value="singapore">Singapore</option>
        </select>
      </div>
      <div>
        <label for="job-location">Job location</label>
        <select id="job-location" v-model="formValues.jobLocation" multiple>
          <option value="india">India</option>
          <option value="vietnam">Vietnam</option>
          <option value="singapore">Singapore</option>
        </select>
      </div>
      <div>
        <input
          id="remoteWork"
          type="checkbox"
          v-model="formValues.remoteWork"
          true-value="yes"
          false-value="no"
        />
        <label for="remoteWork">Open to remote work?</label>
      </div>
      <div>
        <label>Skill set</label>
        <input
          type="checkbox"
          id="html"
          value="html"
          v-model="formValues.skillSet"
        />
        <label for="html">HTML</label>
        <input
          type="checkbox"
          id="css"
          value="css"
          v-model="formValues.skillSet"
        />
        <label for="css">CSS</label>
        <input
          type="checkbox"
          id="javascript"
          value="javascript"
          v-model="formValues.skillSet"
        />
        <label for="javascript">JavaScript</label>
      </div>
      <div>
        <label>Years of Experience</label>
        <input
          type="radio"
          id="0-2"
          value="0-2"
          v-model="formValues.yearsOfExperience"
        />
        <label for="0-2">0-2</label>
        <input
          type="radio"
          id="3-5"
          value="3-5"
          v-model="formValues.yearsOfExperience"
        />
        <label for="3-5">3-5</label>
        <input
          type="radio"
          id="6-10"
          value="6-10"
          v-model="formValues.yearsOfExperience"
        />
        <label for="6-10">5-10</label>
        <input
          type="radio"
          id="10+"
          value="10+"
          v-model="formValues.yearsOfExperience"
        />
        <label for="10+">10+</label>
      </div>
      <div>
        <label for="age">Age</label>
        <input type="number" id="age" v-model.number="formValues.age" />
      </div>
      <div>
        <button>Submit</button>
      </div>
    </form>

    <h2 v-once>{{ name }}</h2>
    <h2>{{ name }}</h2>
    <button @click="name = 'Batman'">Change name</button>

    <!-- computed properties -->

    <h2>Fullname - {{ firstName }} {{ lastName }}</h2>
    <h2>Fullname - {{ fullName }}</h2>
    <h2>
      Total -
      {{ items.reduce((total, curr) => (total = total + curr.price), 0) }}
    </h2>
    <h2>Computed Total - {{ total }}</h2>
    <h2>Method Total - {{ getTotal() }}</h2>
    <button @click="items.push({ id: 4, title: 'Keyboard', price: 50 })">
      Add item
    </button>
    <hr />
    <div>
      {{ country }}
      <input type="text" v-model="country" />
    </div>
  </div>
</template>


<script>
export default {
  name: "App",
  computed: {
    fullName() {
      return `${this.firstName} ${this.lastName}`;
    },
    total() {
      console.log("total computed property called..");
      return this.items.reduce(
        (total, curr) => (total = total + curr.price),
        0
      );
    },
  },
  methods: {
    getTotal() {
      console.log("getTotal method called..");
      return this.items.reduce(
        (total, curr) => (total = total + curr.price),
        0
      );
    },
    increment(step, event) {
      console.log(event);
      this.count += step;
    },
    decrement(step) {
      this.count -= step;
    },
    changeName(event, foo) {
      // console.log("event handler called..");
      // console.log(event);
      // console.log(foo);
      this.name = "Raj";
    },
    add(a, b, c) {
      return a + b + c;
    },
    multiply(a) {
      return a * this.baseValue;
    },
  },
  data() {
    return {
      country: "India",
      items: [
        { id: 1, name: "laptop", price: 100 },
        { id: 2, name: "mouse", price: 10 },
        { id: 3, name: "keyboard", price: 50 },
      ],
      firstName: "Nag",
      lastName: "N",
      formValues: {
        name: "",
        profileSummary: "",
        country: "india",
        jobLocation: ["india"],
        remoteWork: "no",
        skillSet: [],
        yearsOfExperience: "",
        age: "null",
      },
      count: 0,
      name: "Nag",
      baseValue: 30,
      myInfo: {
        name: "Nag",
        age: 35,
        location: "India",
      },
      actors: [
        {
          name: "Tom Cruise",
          movies: ["Mission Impossible", "Top Gun"],
        },
        {
          name: "Brad Pitt",
          movies: ["Fight Club", "Troy"],
        },
        {
          name: "Leonardo DiCaprio",
          movies: ["Titanic", "Inception"],
        },
      ],
      fullNames: [
        { first: "Nag", last: "Raj" },
        { first: "Ram", last: "Raj" },
        { first: "Sam", last: "Raj" },
      ],
      names: ["nag", "ram", "sam"],
      num: "-1",
      message: "Hello Vue!",
      name: "nag",
      htmlMarkup: "<h1>Markup</h1>",
      hack: `<a href="#" onclick="alert('You have been hacked!')">Win a prize!<a/>`,
      todoId: 1,
      isAvailable: false,
      status: "active",
      isPromoted: true,
      soldOut: false,
      highlightColor: "blue",
      headerSize: 30,
      headerStyleObject: {
        color: "purple",
        fontSize: "40px",
        padding: "10px",
      },
      baseStyleObject: {
        color: "black",
        fontSize: "20px",
        padding: "10px",
      },
      successStyleObject: {
        backgroundColor: "green",
      },
      dangerStyleObject: {
        backgroundColor: "red",
      },
    };
  },
};
</script>


<style>
.sold-out {
  color: red;
}
.new {
  color: green;
}
.underline {
  text-decoration: underline;
}
.active {
  color: red;
}
.inactive {
  color: tomato;
}
.promoted {
  background-color: yellow;
}
</style>
