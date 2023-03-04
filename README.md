# MathCalculator

A simple calculator application with multimodule architecture, MVI, Compose, Voyager for courses

Support:
- Dynamic Color
- Theme: Dark, Light
- Languages: RU, EN

## Screenshots
<table>
  <tr>
    <td>Calculator Feature</td>
     <td>Settings Feature</td>
  </tr>
  <tr>
    <td valign="top"><img src="https://i.imgur.com/ubQgaQO.png" align="left" width="350dp"></td>
    <td valign="top"><img src="https://i.imgur.com/TBjt1nC.png" align="right" width="350dp"></td>
  </tr>
 </table>

## User Interface Layer Architecture (MVI+)(Aleshin)
<img src="https://i.imgur.com/wvv6UKw.png" width="80%"></img>

Main components:
1. View (Screen or Fragment/Activity) - user interaction and displays status 
2. BaseViewModel - intermediate logic layer
3. Actor - processing and distribution of event
4. Reducer - updating the state by action
5. WorkProcessor - main work (with managers, interactors etc)
6. State Communicator - state storage
7. CoroutineManager - working with asynchrony
8. Contract - contains ViewState, Events, Effects, Actions

## Standart Feature structure
<p>
<img src="https://i.imgur.com/zXWMQI4.png" width="100%"></img>
</p>

### License

```
Copyright 2023 Stanislav Aleshin

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
